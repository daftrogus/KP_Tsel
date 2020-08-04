<?php
class DB_CONNECT{
    private $conn;

    //melakukan koneksi pada database
    public function connect1(){
        require_once 'config.php';

        $this->conn = new mysqli(DB_HOST,DB_USER,DB_PASSWORD,DB_DATABASE1);
        return $this->conn;
    }

    public function connect2(){
        require_once 'config.php';

        $this->conn = new mysqli(DB_HOST,DB_USER,DB_PASSWORD,DB_DATABASE2);
        return $this->conn;
    }
}
?>