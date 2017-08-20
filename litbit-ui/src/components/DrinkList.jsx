import React from 'react';
import List, {
    ListItem,
    ListItemSecondaryAction,
    ListItemText,
} from 'material-ui/List';
import IconButton from 'material-ui/IconButton';
import Grid from 'material-ui/Grid';
import DeleteIcon from 'material-ui-icons/Delete';
import Card, { CardHeader, CardContent } from 'material-ui/Card';

export default class DrinkList extends React.Component {
    render() {
        var thingsThatGetYouLit = ['Vodka', 'Gin', 'Tequila'];

        return (
            <Grid item xs={6} md={4}>
                <Card>
                    <CardHeader title="Ingredients"/>
                    <CardContent>
                        <div>
                            <List>
                                {thingsThatGetYouLit.map((lighter) =>
                                    <ListItem>
                                        <ListItemText
                                            primary={lighter}
                                        />
                                        <ListItemSecondaryAction>
                                            <IconButton aria-label="Delete">
                                                <DeleteIcon />
                                            </IconButton>
                                        </ListItemSecondaryAction>
                                    </ListItem>
                                )}
                            </List>
                        </div>
                    </CardContent>
                </Card>
            </Grid>
        );
    }
}