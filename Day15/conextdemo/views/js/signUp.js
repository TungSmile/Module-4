function create() {
    let name = $("#name").val();
    let Iduser = $("#id_user").val();
    let pass = $("#password").val();
    let bday = $("#birthday").val();
    let email = $("#email").val();
    let img = $("#img").val();
    let user = {
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
        url: "http://localhost:8080/user/create",
        data: JSON.stringify(user),
        success: function () {
            window.location.href = "signIn.html"
        },
        error: function () {
            alert("login fail")
        }
    })
}