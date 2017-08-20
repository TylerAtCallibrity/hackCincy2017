import React from 'react';
import List, {
    ListItem,
    ListItemText,
} from 'material-ui/List';
import Card, { CardHeader, CardContent } from 'material-ui/Card';
import Grid from 'material-ui/Grid';
import Typography from 'material-ui/Typography';

export default class DrinkList extends React.Component {
    render() {
        var nameOfThingThatGetsYouSuperLit = 'Hahaha U Ded';
        var ingredientsThatGetYouLit = ['Vodka', 'Gin', 'Tequila'];
        var ammountsThatGetYouLit = ['3oz', '1oz', '32oz']
        var howToGetLit = "Mix it and forget it. The description needs to be longer, its 1:25 and Im tired. Well well well I forgot how to use commas.";
        var count=0;

        return (
            <Grid item xs={6} md={4}>
                <Card>
                    <CardHeader title={nameOfThingThatGetsYouSuperLit} className="header"/>
                    <CardContent>
                        {ingredientsThatGetYouLit.map((lighter) =>
                            <ListItem>
                                <ListItemText
                                    primary={lighter}
                                    secondary={ammountsThatGetYouLit[count++]}
                                />
                            </ListItem>
                        )}
                        <Typography component="p">
                            {howToGetLit}
                        </Typography>
                    </CardContent>
                </Card>
            </Grid>
        );
    }
}