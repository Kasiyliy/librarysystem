
var userAPI = Vue.resource('/users/getAllUsers');
var app = new Vue({
    el: '#app',
    template: '<todo-item  :users="users"/>',
    data: {
        users: []
    },
    created: function () {
        userAPI.get().then(result =>
        result.json().then(data =>
        data.forEach(user=>this.users.push(user))
    )
    )
    }
})