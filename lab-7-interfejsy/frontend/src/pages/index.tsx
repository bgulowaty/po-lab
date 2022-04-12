import * as React from 'react';
import {useState} from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardHeader from '@mui/material/CardHeader';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import GlobalStyles from '@mui/material/GlobalStyles';
import Container from '@mui/material/Container';

function deleteNote(id) {
  console.log("Deleting note " + id);
  return fetch('http://localhost:7070/api/notes/' + id, {
    method: 'DELETE',
  });
}

function fetchNotes() {
  return fetch(`http://localhost:7070/api/notes`)
      .then(response => response.json())
      .then(response => response['notes']);
}

function PricingContent() {
  const [fetchedNotes, setNotes] = useState([])

  return (
      <React.Fragment>
        <GlobalStyles styles={{ul: {margin: 0, padding: 0, listStyle: 'none'}}}/>
        <CssBaseline/>
        <AppBar
            position="static"
            color="default"
            elevation={0}
            sx={{borderBottom: (theme) => `1px solid ${theme.palette.divider}`}}
        >
          <Toolbar sx={{flexWrap: 'wrap'}}>
            <Typography variant="h6" color="inherit" noWrap sx={{flexGrow: 1}}>
              Programowanie obiektowe - lab 7 (interfejsy)
            </Typography>
            <nav>
              <button
                  color="text.primary"
                  onClick={() => fetchNotes().then(resultData => setNotes(resultData))}
              >
                Załaduj
              </button>
            </nav>
          </Toolbar>
        </AppBar>
        {/* Hero unit */}
        <Container disableGutters maxWidth="sm" component="main" sx={{pt: 8, pb: 6}}>
          <Typography
              component="h1"
              variant="h2"
              align="center"
              color="text.primary"
              gutterBottom
          >
            Notatki
          </Typography>
        </Container>
        {/* End hero unit */}
        <Container maxWidth="md" component="main">
          <Grid container spacing={5} alignItems="flex-end">
            {fetchedNotes.map((note) => (
                // Enterprise card is full width at sm breakpoint
                <Grid
                    item
                    key={note.title}
                    xs={12}
                    sm={note.title === 6}
                    md={4}
                >

                  <Card>
                    <CardHeader
                        title={note.title}
                        subheader={note.subtitle}
                        titleTypographyProps={{align: 'center'}}
                        // action={tier.title === 'Pro' ? "Noob" : null}
                        subheaderTypographyProps={{
                          align: 'center',
                        }}
                        sx={{
                          backgroundColor: (theme) =>
                              theme.palette.mode === 'light'
                                  ? theme.palette.grey[200]
                                  : theme.palette.grey[700],
                        }}
                    />
                    <CardContent>
                      <Box
                          sx={{
                            display: 'flex',
                            justifyContent: 'center',
                            alignItems: 'baseline',
                            mb: 2,
                          }}
                      >
                        {/*<Typography component="h2" variant="h3" color="text.primary">*/}
                        {/*  ${tier.price}*/}
                        {/*</Typography>*/}
                        {/*<Typography variant="h6" color="text.secondary">*/}
                        {/*  /mo*/}
                        {/*</Typography>*/}
                      </Box>
                      <Typography
                          component="li"
                          variant="subtitle1"
                          align="center"
                      >
                        {note.body}
                      </Typography>
                      ))}
                    </CardContent>
                    <CardActions>
                      <Button fullWidth variant='contained'
                              onClick={() => deleteNote(note.id)
                                  .then(() => fetchNotes())
                                  .then(setNotes)}>
                        Usuń
                      </Button>
                    </CardActions>
                  </Card>
                </Grid>
            ))}
          </Grid>
        </Container>
      </React.Fragment>
  );
}

export default function Pricing() {
  return <PricingContent/>;
}
