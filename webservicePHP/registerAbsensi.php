<?php
require_once 'db_function.php';
$db = new DB_functions();

//respon JSON
$response = array("error"=>FALSE);

if(isset($_POST['email']) && isset($_POST['januari_hadir']) && isset($_POST['januari_sakit']) 
&& isset($_POST['januari_izin']) && isset($_POST['februari_hadir']) && isset($_POST['februari_sakit']) 
&& isset($_POST['februari_izin']) && isset($_POST['maret_hadir']) && isset($_POST['maret_sakit']) 
&& isset($_POST['maret_izin']) && isset($_POST['april_hadir']) && isset($_POST['april_sakit']) 
&& isset($_POST['april_izin']) && isset($_POST['mei_hadir']) && isset($_POST['mei_sakit']) 
&& isset($_POST['mei_izin'])){
    //menerima POST
    $email = $_POST['email'];
    $januari_hadir = $_POST['januari_hadir'];
    $januari_sakit = $_POST['januari_sakit'];
    $januari_izin = $_POST['januari_izin'];
    $februari_hadir = $_POST['februari_hadir'];
    $februari_sakit = $_POST['februari_sakit'];
    $februari_izin = $_POST['februari_izin'];
    $maret_hadir = $_POST['maret_hadir'];
    $maret_sakit = $_POST['maret_sakit'];
    $maret_izin = $_POST['maret_izin'];
    $april_hadir = $_POST['april_hadir'];
    $april_sakit = $_POST['april_sakit'];
    $april_izin = $_POST['april_izin'];
    $mei_hadir = $_POST['mei_hadir'];
    $mei_sakit = $_POST['mei_sakit'];
    $mei_izin = $_POST['mei_izin'];

    if($db->isAbsensiExisted($email)){
        $response["error"] = TRUE;
        $response["error_msg"] = "Absensi pada akun yang sama telah ada!";
        echo json_encode($response);
    }else{
        //fungsi membuat nilai baru
        $absensi = $db->storeAbsensi($email,$januari_hadir,$januari_sakit,$januari_izin,
        $februari_hadir,$februari_sakit,$februari_izin,
        $maret_hadir,$maret_sakit,$maret_izin,
        $april_hadir,$april_sakit,$april_izin,
        $mei_hadir,$mei_sakit,$mei_izin);
        if($absensi){ 
            $response["error"] = FALSE;
            $response["uid"] = $absensi["kode_input"];
            $response["absensi"]["email"] = $absensi["email"];
            $response["absensi"]["januari_hadir"] = $absensi["januari_hadir"];
            $response["absensi"]["januari_sakit"] = $absensi["januari_sakit"];
            $response["absensi"]["januari_izin"] = $absensi["januari_izin"];
            $response["absensi"]["februari_hadir"] = $absensi["februari_hadir"];
            $response["absensi"]["februari_sakit"] = $absensi["februari_sakit"];
            $response["absensi"]["februari_izin"] = $absensi["februari_izin"];
            $response["absensi"]["maret_hadir"] = $absensi["maret_hadir"];
            $response["absensi"]["maret_sakit"] = $absensi["maret_sakit"];
            $response["absensi"]["maret_izin"] = $absensi["maret_izin"];
            $response["absensi"]["april_hadir"] = $absensi["april_hadir"];
            $response["absensi"]["april_sakit"] = $absensi["april_sakit"];
            $response["absensi"]["april_izin"] = $absensi["april_izin"];
            $response["absensi"]["mei_hadir"] = $absensi["mei_hadir"];
            $response["absensi"]["mei_sakit"] = $absensi["mei_sakit"];
            $response["absensi"]["mei_izin"] = $absensi["mei_izin"];
            
            echo json_encode($response);
        }else{
            $response["error"] = TRUE;
            $response["error_msg"] = "ERROR CODE : 2 | Terdapat sebuah error pada input Absensi !";
            echo json_encode($response);
        }
    }
}else{
    $response["error"] = TRUE;
    $response["error_msg"] = "ERROR CODE : 1 | Terdapat sebuah error pada input Absensi !";
    echo json_encode($response);
}
?>