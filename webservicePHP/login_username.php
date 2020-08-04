<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['username']) && isset($_POST['password'])){
    //menerima POST 
    $username = $_POST['username'];
    $password = $_POST['password'];

    $user = $db->getUserByUsernamePassword($username,$password);

    if($user != FALSE){
        $response["error"] = FALSE;
        $response["uid"] = $user["unique_id"];
        $response["user"]["username"] = $user["username"];
        $response["user"]["created_at"] = $user["created_at"];
        $response["user"]["updated_at"] = $user["updated_at"];
        echo json_encode($response);
        }else{
        $response["error"] = TRUE;
        $response["error_msg"] = "Parameter dibutuhkan, (Username / Email ,password) tidak ditemukan";
        echo json_encode($response);
    }
}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "Parameter dibutuhkan, (Username / Email ,password) tidak ditemukan";
    echo json_encode($response);
}
?>