<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['email']) && isset($_POST['mata_pelajaran']) && isset($_POST['nilai_januari']) 
&& isset($_POST['nilai_februari']) && isset($_POST['nilai_maret']) && isset($_POST['nilai_april']) 
&& isset($_POST['nilai_mei'])){
    //menerima POST
    $email = $_POST['email'];
    $mata_pelajaran = $_POST['mata_pelajaran'];
    $nilai_januari = $_POST['nilai_januari'];
    $nilai_februari = $_POST['nilai_februari'];
    $nilai_maret = $_POST['nilai_maret'];
    $nilai_april = $_POST['nilai_april'];
    $nilai_mei = $_POST['nilai_mei'];

    if(($db->isUserExisted($email)) && ($db->isNilaiExisted($mata_pelajaran))){
        $response["error"] = TRUE;
        $response["error_msg"] = "Nilai dengan Email dan Mata pelajaran yang sama telah ada!";
        echo json_encode($response);
    }else{
        //fungsi membuat nilai baru
        $nilai = $db->storeNilai($email,$mata_pelajaran,$nilai_januari,$nilai_februari,$nilai_maret,$nilai_april,$nilai_mei);
        if($nilai){ 
            $response["error"] = FALSE;
            $response["uid"] = $nilai["kode_input"];
            $response["nilai"]["email"] = $nilai["email"];
            $response["nilai"]["mata_pelajaran"] = $nilai["mata_pelajaran"];
            $response["nilai"]["nilai_januari"] = $nilai["nilai_januari"];
            $response["nilai"]["nilai_februari"] = $nilai["nilai_februari"];
            $response["nilai"]["nilai_maret"] = $nilai["nilai_maret"];
            $response["nilai"]["nilai_april"] = $nilai["nilai_april"];
            $response["nilai"]["nilai_mei"] = $nilai["nilai_mei"];
            echo json_encode($response);
        }else{
            $response["error"] = TRUE;
            $response["error_msg"] = "Terdapat sebuah error pada input Nilai !";
            echo json_encode($response);
        }
    }
}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "Email/ Mata Pelajaran / Nilai anda Salah/Kosong";
    echo json_encode($response);
}
?>