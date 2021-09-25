const fs = require('fs');

const data = fs.readFile('./data.txt', 'utf8', function (err, data) {
  console.log(data);
});
