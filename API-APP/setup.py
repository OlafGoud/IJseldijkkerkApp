import sqlite3

con = sqlite3.connect("KerkApp.db")
cur = con.cursor()
cur.execute("DROP TABLE messages")

cur.execute("CREATE TABLE messages(chat, user, message, time, date)")

cur.execute("INSERT INTO messages VALUES('mainchat', 'firstuser', 'hello world', '19:29', '1-6-2024')")
cur.execute("INSERT INTO messages VALUES('mainchat', 'seconduser', 'Haaaai', '19:30', '1-6-2024')")


res = cur.execute("SELECT * FROM messages")
con.commit()
for row in res:
    print(row)
cur.close()