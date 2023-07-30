function show() {
    $.ajax({
        type: "Get",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/user",
        success: function (data) {
            showlist(data);
        },
        error: function (err) {
            console.log(err)
        }
    })

    function showlist(arr) {
        let temp = '';
        for (const u of arr) {
            temp += '<tr> <th>${u.id}</th>\n' +
                '            <th>${u.name}</th>\n' +
                '            <th>${u.id_user}</th>\n' +
                '            <th>${u.password}</th>\n' +
                '            <th>${u.birthday}</th>\n' +
                '            <th>${u.email}</th>\n' +
                '            <th><img src="${u.img}"></th>\n' +
                '            <th><a onclick="deleteUser(${u})"></a></th>\n' +
                '            <th>Action</th>'

        }
    }
}

function deleteUser(user) {
let u={
    id:user.id,
    name:user.name,
    id_user:user.id_user,
    password:user.password,
    birthday:user.birthday,
    email:user.email,
    img:user.img}

    $.ajax({
        type: "Post",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/user",
        data:JSON.stringify(u),
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
        }
    })

}