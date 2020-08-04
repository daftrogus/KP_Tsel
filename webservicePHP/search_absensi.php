<?php
require_once 'db_function.php';
$db = new DB_functions();


//respon JSON
//$response = array("error"=>FALSE);

if(isset($_POST['email']) && isset($_POST['bulan'])){
    //menerima POST
    $email = $_POST['email'];
    $bulan = $_POST['bulan'];

    if($bulan == "januari"){
        $searchabsensi = $db->isAbsensiExisted_januari($email);
    }elseif($bulan == "februari"){
        $searchabsensi = $db->isAbsensiExisted_februari($email);
    }elseif($bulan == "maret"){
        $searchabsensi = $db->isAbsensiExisted_maret($email);
    }elseif($bulan == "april"){
        $searchabsensi = $db->isAbsensiExisted_april($email);
    }elseif($bulan == "mei"){
        $searchabsensi = $db->isAbsensiExisted_mei($email);
    }

    if($email != NULL){
        echo json_encode($searchabsensi);
    }else{
        //$response["error"] = TRUE;
        $response = "Presensi dengan Email Tidak Ditemukan";
        echo json_encode($response);
    }

}//else{
 //   $response["error"] = TRUE;
 //   $response["error_msg"] = "$no_hp";
 //   echo json_encode($response);
//}
?>