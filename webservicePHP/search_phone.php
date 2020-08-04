<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
//$response = array("error"=>FALSE);

if(isset($_POST['mobilephone'])){
    //menerima POST
    $mobilephone = $_POST['mobilephone'];

    $searchphone = $db->isPhoneExisted($mobilephone);

    if($searchphone != NULL){
        //$response["error"]["no_hp"] = $searchphone["no_hp"];
        // echo json_encode($searchphone);
        // $response["no_hp"] = $searchphone;
        echo json_encode($searchphone);
    }else{
        //$response["error"] = TRUE;
        $response = "Data Tidak Ditemukan";
        echo json_encode($response);
    }

}//else{
 //   $response["error"] = TRUE;
 //   $response["error_msg"] = "$no_hp";
 //   echo json_encode($response);
//}
?>