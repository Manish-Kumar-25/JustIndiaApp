const express = require('express');
const cors = require('cors');
const spots = require('./data/spots');

const app = express();
app.use(cors());

app.get('/states', (req, res) => {
    const stateNames = Object.keys(spots)
    console.log(stateNames);
    if (stateNames) res.json(stateNames);
    else res.status(404).json({ message: "No states found" });
  });  

app.get('/spots/:state', (req, res) => {
    const state = req.params.state;
    const data = spots[state];
    if (data) res.json(data);
    else res.status(404).json({ message: "No data for this state" });
});

const PORT = 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
