
var userAPI = Vue.resource('/users/getAllUsers');
Vue.component("todo-item",{
    props:['users'],
    template: ' <table class="table table-bordered table-hovered" style = "width:80%;margin-left:250px">\n' +
    '            <thead>\n' +
    '            <tr>\n' +
    '                <th scope="col">id</th>\n' +
    '                <th scope="col">name</th>\n' +
    '                <th scope="col">patronomyc</th>\n' +
    '                <th scope="col">username</th>\n' +
    '                <th scope="col">update</th>\n' +
    '                <th scope="col">delete</th>\n' +
    '            </tr>\n' +
    '            </thead>' +
    '             <tbody>' +
    '              <tr v-for="user in users">' +
    '               <td>{{user.id}}</td>' +
    '               <td>{{user.name}}</td>' +
    '               <td>{{user.patronomyc}}</td>' +
    '               <td>{{user.surname}}</td>' +
    '               <td><input type = "button" value="update"></td>' +
    '               <td><input type = "button" value="delete"></td>' +
    '              </tr>' +
    '             </tbody>' +
    '             </table>',
    created: function () {
        userAPI.get().then(result =>
            result.json().then(data =>
                data.forEach(user=>this.users.push(user))
            )
        )
    }
});
var app = new Vue({
    el: '#app',
    template: '<todo-item  :users="users"/>',
    data: {
        users: []
    }
})