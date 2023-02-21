const express = require('express');
const mysql = require ('mysql');
const app = express();
const conn = mysql.createConnection({
	host: "localhost",
	user: "root",
	password: "Group21",
	database: "test_database",
});

conn.connect(function(err) {
	if (err) throw err;
	console.log("Connected!");
});

app.get('/', (req, res) => {
	conn.query("SELECT * FROM test_database", function (err, result, fields) {
		if (err) throw err;
		res.send(result);
	});
});

app.listen(3000, () => console.log('Listening on port 3000...'));