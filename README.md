# MetroCenterDataService
basic web app to log in and see data connects with SecurityAPI for token generation and validation. SecurityAPI creates tokens
with the same default username leading to the same scope for each token. This can be updated to give each user's username to generate the token and it would require changing the AuthFilter scope to accept only the specific user scope not the default user scope.
