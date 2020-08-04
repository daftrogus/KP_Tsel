<?php

class DB_functions_phone{
    private $conn;

    //constructor
    function __construct(){
        require_once 'db_connect.php';
        $db = new DB_Connect();
        $this->conn = $db->connect2();
    }

    function __destruct(){
        //mengimplementasikan __destruct() method.
    }

    //menambahkan user baru ketika daftar pada halmn LOGIN .
    //mengembalikan detail user.
    public function storePhone($no_hp,$nama_hp){

        $statement = $this->conn->prepare("INSERT INTO data_hp(nama_hp,no_hp)VALUES (?,?)");
        $statement->bind_param("ss",$no_hp,$nama_hp);
        $result = $statement->execute();
        $statement->close();

        //cek untuk melihat pengisian data yg sukses
        if($result){
            $statement = $this->conn->prepare("SELECT * FROM data_hp WHERE no_hp=?");
            $statement->bind_param("s",$no_hp);
            $statement->execute();
            $handphone = $statement->get_result()->fetch_assoc();
            $statement->close();

            return $handphone;
        }else{
            return false;
        }
    }

    function isPhoneExisted($no_hp){
        $statement = $this->conn->prepare("SELECT nama_hp FROM data_hp WHERE no_hp='$no_hp'");
        //$statement->bind_param("s",$no_hp);
        $statement->execute();
        $phone = $statement->get_result()->fetch_assoc();
        $statement->store_result();

        if($statement){
            return $phone;
        }else{
            return "";
        }
    }
}
?>