# Leaderboard API

This REST API is designed to track and manage the scores of teams in any competition. For convenience,
an MVC pattern is also implemented to easily display the results.

## Overview
Board example:

![image](https://user-images.githubusercontent.com/19227717/218143123-0ec3845e-631d-4644-b545-02d466fc64e6.png)

This API provides the management of the teams and users.

Users can:
- be registered (by default with the user role),
- have their role updated,
- be deleted

Teams can:
- be added
- have their points changed

## Endpoints

### MVC endpoints
Managing points, teams and users requires user to be logged in with *admin* role. If user is not logged in it redirects to the login page.

- `/` - returns view with scoreboard
- `/points/add` - returns the view with form for adding points to selected user
- `/teams/add` - returns the view with form for adding a new team
- `/register` - returns the view with form for registering a new user
- `/management/users` - returns view with list of registered users and their roles
- `/management/users/{id}` - returns the view with the data of the user and the form to delete the user or to change his role.

### REST endpoints
Managing points, teams and users requires to be authorized using basic auth for the user with the *admin* role.

- *POST* `/register` - registers a new users; requieres a form-data body with fields *username*, *password* and *password2* to be sent
- *POST* `/management/users/{id}/update_role` - updates the role of the user with id *id* to the one specified in form-data body as *selectedRole*
- *POST* `/management/users/{id}/delete` - deletes the user with specified id
- *POST* `/points/add` - adds points to the team specified in form-data body with fields *selectedTeam* and *pointsToAdd*
- *POST* `/teams/add` - adds a new team; requieres a form-data body with field *teamName* to be sent
