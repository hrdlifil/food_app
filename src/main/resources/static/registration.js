
var dement = 1;

function showAddress() {

    if (dement % 2 == 0){

        document.getElementById("lol").style.display = "none";
        dement = false;
    }else{

        document.getElementById("lol").style.display = "inline";
        dement = true;
    }

    dement++;

}

function checkInfo() {

    var a = document.getElementById("login").value;
    var b = document.getElementById("heslo").value;
    var c = document.getElementById("jmeno").value;
    var d = document.getElementById("prijmeni").value;
    var e = document.getElementById("email").value;
    var f = document.getElementById("phone").value;

    if (a.length < 2){

        alert("Uživatelské jméno musí mít alespoň 2 znaky");
        return false;
    }
    if (b.length < 4){

        alert("Heslo musí mít alespoň 4 znaky");
        return false;
    }
    if (c.length < 2){

        alert("Jméno musí mít alespoň 2 znaky");
        return false;
    }
    if (d.length < 2){

        alert("Přijímení musí mít alespoň 2 znaky");
        return false;
    }
    if (e.length < 5){

        alert("Zadejte prosím validní e-mail");
        return false;
    }
    if (f.length < 9){

        alert("Zadejte prosím validní telefonní číslo");
        return false;
    }





    else {

        return true;
    }
    
}