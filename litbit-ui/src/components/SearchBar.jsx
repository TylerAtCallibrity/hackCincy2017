
import React from 'react';
import List, {
    ListItem,
    ListItemText,
} from 'material-ui/List';
import Card, { CardContent, CardActions } from 'material-ui/Card';
import Grid from 'material-ui/Grid';
import Typography from 'material-ui/Typography';
import PropTypes from 'prop-types';
import Autosuggest from 'react-autosuggest';
import TextField from 'material-ui/TextField';
import Button from 'material-ui/Button';
import Paper from 'material-ui/Paper';
import { MenuItem } from 'material-ui/Menu';
import { withStyles } from 'material-ui/styles';
import axios from 'axios'

function callServer(){

    var requestBody = '{"data":{"ingredients":["cranberry juice","orange juice","vodka"]}}'
    // var output = fetch('0.0.0.0:4567/drink', {
    //     method: 'POST',
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify({
    //         firstParam: requestBody
    //     })
    // })
    axios.get('http://localhost:4567/hello')
        .then(function (response){
            console.log(`TWRR >> resp=${response}`)
        })
        .catch(function(error){
            console.log(`TWRR >> NONONONONO error=${error}`)
        })
    
}

export default class DrinkList extends React.Component {

    constructor(props){
        super(props);
        this.handleClick = this.handleClick.bind(this);    
    }

    handleClick() {
        callServer();
    }

    render() {

        return (
            <Grid item xs={6} md={4}>
                <Card>
                    <CardContent>
                        <TextField
                            id="Ingredient"
                            label="New Ingredient"
                            InputProps={{ placeholder: 'Enter ingredient name here' }}
                            helperText="Add new ingredients to your mix!"
                            fullWidth
                            margin="normal"
                        />
                    </CardContent>
                    <CardActions>
                        <Button  raised color="primary" onClick={this.handleClick}>Add</Button>
                    </CardActions>
                </Card>
            </Grid>
        );
    }
}