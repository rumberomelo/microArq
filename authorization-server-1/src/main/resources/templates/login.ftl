<!DOCTYPE html>
<html lang="en" ng-app="BlankApp">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Angular Material style sheet -->
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.1/angular-material.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="http://localhost:9111/style.css?fafd" rel="stylesheet">
</head>

<body ng-cloak ng-controller="MainCtrl">

  <div layout="column" layout-align="center center" layout-fill="layout-fill">
    <div layout="column" class="loginBox md-whiteframe-z1">
      <md-toolbar>
        <h2 class="md-toolbar-tools"><span>Login</span></h2>
      </md-toolbar>
      <form name="loginForm" role="form" action="login" method="post">
        <md-content layout="column" class="md-padding">
          <md-input-container>
            <label>Username</label>
            <input required type="text" ng-model="loginModel.username" name="username" />
            <div ng-messages="loginForm.username.$error">
              <div ng-message="required">This is required.</div>
            </div>
          </md-input-container>
          <md-input-container>
            <label>Password</label>
            <input required type="password" ng-model="loginModel.password" name="password" />
            <div ng-messages="loginForm.password.$error" role="alert">
              <div ng-message="required">This is required.</div>
            </div>
          </md-input-container>
          <div layout="row" layout-align="center center">
            <md-button type="submit" class="md-raised md-primary">Login</md-button>
            <div flex="flex"></div>
            <md-button href="" md-no-ink>Forgot Password</md-button>
          </div>
          <md-divider></md-divider>
          <md-button href="#" md-no-ink>Sign Up</md-button>
        </md-content>
      </form>
    </div>
  </div>

  <!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-animate.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-aria.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-messages.min.js"></script>
  <!-- Angular Material Library -->
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.1/angular-material.min.js"></script>
  <script src="http://localhost:9111/app.js"></script>
</body>

</html>