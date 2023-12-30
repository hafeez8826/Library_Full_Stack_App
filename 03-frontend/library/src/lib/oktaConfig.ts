
export const oktaConfig = {
  clientId: '0oae7bg0tfDjKiLWG5d7',
  issuer: 'https://dev-05048357.okta.com/oauth2/default',
  redirectUri: 'http://localhost:3000/login/callback',
  scopes: ['openid', 'profile', 'email'],
  pkce: true,
  disableHttpsCheck: true,
}

export default oktaConfig ;





