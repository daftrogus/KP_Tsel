<?php
require_once 'db_function.php';
$db = new DB_functions();


//respon JSON
//$response = array("error"=>FALSE);

if(isset($_POST['email'])){
    //menerima POST
    $email = $_POST['email'];

    $searchnilai = $db->isNilaiTotalExisted($email);

    if($email != NULL){
        echo json_encode($searchnilai);
    }else{
        //$response["error"] = TRUE;
        $response = "Nilai dengan Email Tidak Ditemukan";
        echo json_encode($response);
    }

}//else{
 //   $response["error"] = TRUE;
 //   $response["error_msg"] = "$no_hp";
 //   echo json_encode($response);
//}
?>