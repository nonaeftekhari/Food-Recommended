const functions = require('./functions');


//Username test
test('Username should not be null', () => {
    expect(functions.username()).not.toBeNull();
});

// creates user with fake data
test('The User name should be Mike Johnson', () => {
    expect(functions.createUser()).toEqual({
      firstName: 'Mike',
      lastName: 'Johnson'
    });
});

//password validation
test('password must be 8 characters long or greater', () => {

    expect(functions.password()).toBeGreaterThanOrEqual(8);

});

// Testing email should have @ sign
test('Joey@gmail.com has @', () => {
    expect('Joey@gmail.com').toMatch(/@/);

});

//getting record of existing users test
const getRecord = () => ({ id: 1, 'fullName': 'Sarah Paulson', 'email': 'sarah23@gmail.com'});
test('recorded user has a fullname, email and id', () => {
    let record = getRecord(1);
    expect(record).toHaveProperty('id');
    expect(record).toHaveProperty('fullName');
    expect(record).toHaveProperty('email');
});

// testing zipcode should be 5 numbers
test('zip code should eual to 5 numbers', () => {
    expect(functions.zipcode()).toEqual(5);
});


 
