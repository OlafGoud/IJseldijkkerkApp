import sqlite3

con = sqlite3.connect("KerkApp.db")
cur = con.cursor()

cur.execute("INSERT INTO messages VALUES('subchat', 'firstuser', 'hello worlld', '20:09', '2-6-2024')")
con.commit()
cur.close()