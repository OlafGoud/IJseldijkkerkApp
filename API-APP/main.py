from flask import Flask, request, jsonify
import sqlite3
app = Flask(__name__)






@app.route("/get-user/<user_id>")
def home(user_id):
    userData = {
        "user_id": user_id,
    }
    print("Data: " + user_id)

    extra = request.args.get("extra")
    if extra:
        userData["extra"] = extra


    return jsonify(userData), 200


@app.route("/api/chats")
def chat():
    con = sqlite3.connect("KerkApp.db")
    cur = con.cursor()
    chatVariable = request.args.get("chat")
    if(chatVariable):
        print(str(chatVariable))
        chatVariable = str(chatVariable)
        if (chatVariable == "mainchat"):
            res = cur.execute("SELECT * FROM messages WHERE chat = 'mainchat' order by date, time DESC")

    else:
        return
    outputrow = []
    output = []
    for row in res:
        print(row)
        for item in row:
            outputrow.append(item)
        
        #output = "{\"chat\":\""+outputrow[0]+"\"}"
        
        output.append({
            "chat" : outputrow[0], 
            "user" : outputrow[1],
            "message" : outputrow[2],
            "time" : outputrow[3],
            "date" : outputrow[4]
        })
        outputrow = []

    cur.close()
    return (output), 200





@app.route("/create-user", methods=["POST"])
def create_user():
    data = request.get_json()
    return jsonify(data), 201


if __name__ == "__main__":
    app.run(debug=True)