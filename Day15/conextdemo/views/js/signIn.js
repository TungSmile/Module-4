function login() {
    let IdUser = $("#id_user").val();
    let pass = $("#password").val();

    var formData = new FormData();
    formData.append("user", IdUser);
    formData.append("password", pass);
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/user/login",
        data: formData,
        processData: false,
        // tránh mặc định thành string
        contentType: false,
        // để chỉnh đc content type tránh thành mặc định
        success: function (user) {
            if (user !== null) {
                window.location.href = "home.html"
            } else {
            }
            ;
        },
        error: function (err) {
            alert(err)
        }
    })
}