var express = require('express');
var app = express();
var morgan = require('morgan');
var users = [
    { id: 1, name: 'alice' },
    { id: 2, name: 'bak' },
    { id: 3, name: 'Chris' },
];

app.use(morgan('dev'));

app.get('/users', function (req, res) {
    req.query.limit = req.query.limit || 10;
    const limit = parseInt(req.query.limit, 10);
    if (Number.isNaN(limit)) {
        return res.status(400).end();
    }
    res.json(users.slice(0, limit));
});

app.get('/users/:id', function (req, res) {
    const id = parseInt(req.params.id, 10);
    const user = users.filter((user) => user.id === id)[0];
    res.json(user);
});

app.listen(3000, function () {
    console.log('Exmple app listening on port 3000!');
});

module.exports = app;
