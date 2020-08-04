<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['email']) && isset($_POST['username']) && isset($_POST['fullname']) 
&& isset($_POST['mobilephone']) && isset($_POST['password'])){
    //menerima POST
    $email = $_POST['email'];
    $username = $_POST['username'];
    $fullname = $_POST['fullname'];
    $mobilephone = $_POST['mobilephone'];
    $password = $_POST['password'];

    if($db->isUserExisted($email)){
        $response["error"] = TRUE;
        $response["error_msg"] = "User telah ada dengan email : ".$email;
        echo json_encode($response);
    }else{
        //fungsi membuat user baru
        $user = $db->storeUser($email,$username,$fullname,$mobilephone,$password);
        if($user){
            $response["error"] = FALSE;
            $response["user"]["email"] = $user["email"];
            $response["uid"] = $user["unique_id"];
            $response["user"]["username"] = $user["username"];
            $response["user"]["fullname"] = $user["fullname"];
            $response["user"]["mobilephone"] = $user["mobilephone"];
            $response["user"]["created_at"] = $user["created_at"];
            $response["user"]["updated_at"] = $user["updated_at"];
            echo json_encode($response);
        }else{
            $response["error"] = TRUE;
            $response["error_msg"] = "Terdapat sebuah error pada Registrasi !";
            echo json_encode($response);
        }
    }
}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "Nama / Email / Password anda Salah/Kosong";
    echo json_encode($response);
}
?>