<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['email']) && isset($_POST['password'])){
    //menerima POST
    $email = $_POST['email'];
    $password = $_POST['password'];

    $user = $db->getUserByEmailPassword($email,$password);

    if($user != false){	
        $response["error"] = FALSE;
        $response["uid"] = $user["unique_id"];
        $response["user"]["email"] = $user["email"];
        $response["user"]["created_at"] = $user["created_at"];
        $response["user"]["updated_at"] = $user["updated_at"];	
        echo json_encode($response);
    }else{
        $response["error"] = TRUE;
        $response["error_msg"] = "Parameter dibutuhkan, WADAW (name,email,password) tidak ditemukan";
        echo json_encode($response);
    }

}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "Parameter dibutuhkan,WODOW (name,email,password) tidak ditemukan";
    echo json_encode($response);
}
?>