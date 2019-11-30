
var name;

var email;

var password;

var username;
var zipcode = 48202;

const functions =  {
    
  createUser: () => {
      const user = { firstName: 'Mike' };
      user['lastName'] = 'Johnson';
      return user;
    },

    email: () => email,

    password: () => 8,  
    username: () => username,
    zipcode: () => 5,

}

module.exports = functions;
