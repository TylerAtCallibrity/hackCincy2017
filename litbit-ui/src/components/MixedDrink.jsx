import React from 'react';
import List, {
    ListItem,
    ListItemText,
} from 'material-ui/List';
import Card, { CardHeader, CardContent } from 'material-ui/Card';
import Grid from 'material-ui/Grid';
import Typography from 'material-ui/Typography';
import AppBar from 'material-ui/AppBar';
import PropTypes from 'prop-types';
import Tabs, { Tab } from 'material-ui/Tabs';

function TabContainer(props) {
    return (
        <div style={{ padding: 20 }}>
            {props.children}
        </div>
    );
}

TabContainer.propTypes = {
    children: PropTypes.node.isRequired,
};

export default class DrinkList extends React.Component {
    state = {
        value: 0,
    };

    handleChange = (event, value) => {
        this.setState({ value });
    };
    render() {
        const { classes } = this.props;
        const { value } = this.state;

        var nameOfThingThatGetsYouSuperLit = 'Hahaha U Ded';
        // var ammountsThatGetYouLit = ['3oz', '1oz', '32oz']
        var howToGetLit = "Mix it and forget it. The description needs to be longer, its 1:25 and Im tired. Well well well I forgot how to use commas.";
        var count=0;

        //.get(blah.com/{this.props.ingredients})

        //0 hard coded
        var returnedObjects = [1,2,3,4,5,6,7,8,9]


        return (
            <Grid item xs={12} md={4}>
                <Card>
                    <AppBar position="static" color="default">
                        <Tabs
                            value={value}
                            onChange={this.handleChange}
                            indicatorColor="primary"
                            textColor="primary"
                            scrollable
                            scrollButtons="auto"
                        >
                            <Tab label="Drink One" />
                            <Tab label="Drink Two" />
                            <Tab label="Drink Three" />
                            <Tab label="Drink Four" />
                            <Tab label="Drink Five" />
                            <Tab label="Drink Six" />
                            <Tab label="Drink Seven" />
                            <Tab label="Drink Eight" />
                            <Tab label="Drink Nine" />
                            <Tab label="Drink Ten" />


                        </Tabs>
                    </AppBar>
                    <CardContent>
                        {value === 0 &&
                            <TabContainer>
                                <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                                <Typography component="p">
                                    {howToGetLit}
                                </Typography>
                                {this.props.ingredients}
                            </TabContainer>
                        }
                        {value === 1 &&
                            <TabContainer>
                                <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                                <Typography component="p">
                                    {howToGetLit}
                                </Typography>
                            </TabContainer>
                        }
                        {value === 2 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 3 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 4 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 5 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 6 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 7 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 8 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                        {value === 9 &&
                        <TabContainer>
                            <Typography type="title">{nameOfThingThatGetsYouSuperLit}</Typography>
                            <Typography component="p">
                                {howToGetLit}
                            </Typography>
                        </TabContainer>
                        }
                    </CardContent>
                </Card>
            </Grid>
        );
    }
}