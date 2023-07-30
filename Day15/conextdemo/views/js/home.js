function show() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json'
        },
        url: "http://localhost:8080/user",
        success: function (data) {
            showlist(data);
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function showlist(arr) {
    let temp = "";
    for (const u of arr) {
        let obj = JSON.stringify(u)
        temp += `<tr><th>${u.id}</th>
<th>${u.name}</th>
<th>${u.id_user}</th>
<th>${u.password}</th>
<th>${u.birthday}</th>
<th>${u.email}</th><th>
<img src="${u.img}" style="width: 50px;height: 50px"></th>
<th><button onclick='deleteUser(${obj})'>Delete</button></th>
<!--<th><button onclick='deleteUser(`+JSON.stringify(u)+`)'>Delete</button></th>-->
<th><button onclick='editUser(`+JSON.stringify(u)+`)'>Delete</button></th>`
    }
    document.getElementById("showList").innerHTML = temp;
}


show();

function deleteUser(u) {

    // let name= user.name;
    // let id_user= user.id_user;
    // let password= user.password;
    // let birthday= user.birthday;
    // let email= user.email;
    // let img= user.img;
    // let u = {
    //     id: idU
    // }
    // name: name,
    //     id_user: id_user,
    //     password: password,
    //     birthday: birthday,
    //     email: email,x
    //     img: img
    // }

    $.ajax({
        type: "POST",
        headers: {
            'Authorization':localStorage.getItem("token"),
            // lấy token từ localStorage
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/user/delete",
        data: JSON.stringify(u),
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
        }
    })
}
function create() {
let name=$("#name").val();
let Iduser=$("#id_user").val();
let pass=$("#password").val();
let bday=$("#birthday").val();
let email=$("#email").val();
let img=$("#img").val();
let user={
            name: name,
            id_user: Iduser,
            password: pass,
            birthday: bday,
            email: email,
            img: img
    }

    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/user",
        data: JSON.stringify(user),
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
        }
    })
}