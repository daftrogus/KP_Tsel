<?php
require_once 'db_function_phone.php';
$db = new DB_functions_phone();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['no_hp']) && isset($_POST['nama_hp'])){
    //menerima POST
    $no_hp = $_POST['no_hp'];
    $nama_hp = $_POST['nama_hp'];

    //fungsi membuat phone baru
    $handphone = $db->storePhone($no_hp,$nama_hp);
    if($handphone){
        $response["error"] = FALSE;
        $response["handphone"]["no_hp"] = $handphone["no_hp"];
        $response["handphone"]["nama_hp"] = $handphone["nama_hp"];
        echo json_encode($response);
    }else{
        $response["error"] = TRUE;
        $response["error_msg"] = "Nomor Handphone Telah berhasil di masukkan !";
        echo json_encode($response);
    }
}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "Data yang dibutuhkan tidak terpenuhi";
    echo json_encode($response);
}
?>