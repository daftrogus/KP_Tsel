<?php

class DB_functions{
    private $conn;

    //constructor
    function __construct(){
        require_once 'db_connect.php';
        $db = new DB_Connect();
        $this->conn = $db->connect1();
    }

    function __destruct(){
        //mengimplementasikan __destruct() method.
    }

    //menambahkan user baru ketika daftar pada halmn LOGIN .
    //mengembalikan detail user.
    public function storeUser($email,$username,$fullname,$mobilephone,$password){
        $uuid = uniqid('',true);
        $hash = $this->hashSSHA($password);
        $encrypt_password = $hash["encrypted"]; //meng-enkripsi password
        $salt = $hash["salt"];

        $statement = $this->conn->prepare("INSERT INTO users(email,unique_id,username,fullname,mobilephone,encrypted_password,salt,created_at)VALUES (?,?,?,?,?,?,?,NOW())");
        $statement->bind_param("sssssss",$email,$uuid,$username,$fullname,$mobilephone,$encrypt_password,$salt);
        $result = $statement->execute();
        $statement->close();
        //cek untuk melihat pengisian data yg sukses
        if($result){
            $statement = $this->conn->prepare("SELECT * FROM users WHERE email=?");
            $statement->bind_param("s",$email);
            $statement->execute();
            $user = $statement->get_result()->fetch_assoc();
            $statement->close();
            
            return $user;
        }else{
            return false;
        }
    }

    //fungsi get User dengan email dan password
    public function getUserByEmailPassword($email,$password){
        $statement = $this->conn->prepare("SELECT * FROM users WHERE email=? OR username=?");
        $statement->bind_param("ss",$email,$email);

        if($statement->execute()){
            $user = $statement->get_result()->fetch_assoc();
            $statement->close();

            //verifikasi user password
            $salt = $user['salt'];
            $encrypted_password = $user['encrypted_password'];
            $hash = $this->checkhashSSHA($salt,$password);
            //check kesamaan password
            if($encrypted_password == $hash){
                return $user;
            }
        }
        else{
            return NULL;
        }
    }

    //fungsi mengecek user apakah datanya terdaftar atau tidak
    function isUserExisted($email){
        $statement = $this->conn->prepare("SELECT email FROM users WHERE email=?");
        $statement->bind_param("s",$email);
        $statement->execute();
        $statement->store_result();

        if($statement->num_rows > 0){
            $statement->close();
            return true;
        }else{
            $statement->close();
            return false;
        }
    }

    //fungsi meng-enkripsi password
    public function hashSSHA($password){
        $salt = sha1(rand());
        $salt = substr($salt,0,10);
        $encrypted = base64_encode(sha1($password.$salt,true).$salt);
        $hash = array("salt"=>$salt,"encrypted"=>$encrypted);   

        return $hash;
    }

    //fungsi meng-dekripsi password
    public function checkhashSSHA($salt,$password){
        $hash = base64_encode(sha1($password.$salt,true).$salt);
        return $hash;
    }

    public function storeNilai($email,$mata_pelajaran,$nilai_januari,$nilai_februari,$nilai_maret,$nilai_april,$nilai_mei){
        $kode_input = uniqid('',true);

        $statement = $this->conn->prepare("INSERT INTO nilaisiswa(kode_input,email,mata_pelajaran,nilai_januari,nilai_februari,nilai_maret,nilai_april,nilai_mei)VALUES (?,?,?,?,?,?,?,?)");
        $statement->bind_param("ssssssss",$kode_input,$email,$mata_pelajaran,$nilai_januari,$nilai_februari,$nilai_maret,$nilai_april,$nilai_mei);
        $result = $statement->execute();
        $statement->close();
        //cek untuk melihat pengisian data yg sukses
        if($result){
            $statement = $this->conn->prepare("SELECT * FROM nilaisiswa WHERE email=?");
            $statement->bind_param("s",$email);
            $statement->execute();
            $nilai = $statement->get_result()->fetch_assoc();
            $statement->close();
            
            return $nilai;
        }else{
            return false;
        }
    }

    function isNilaiExisted($mata_pelajaran){
        $statement = $this->conn->prepare("SELECT mata_pelajaran FROM nilaisiswa WHERE mata_pelajaran=?");
        $statement->bind_param("s",$mata_pelajaran);
        $statement->execute();
        $statement->store_result();

        if($statement->num_rows > 0){
            $statement->close();
            return true;
        }else{
            $statement->close();
            return false;
        }
    }

    function isNilaiTotalExisted($email){
        // $statement = $this->conn->prepare("SELECT * FROM nilaisiswa WHERE email=?");
        // $statement->bind_param("s",$email);
        // $statement->execute();
        // $statement->store_result();

        // if($statement->num_rows > 0){
        //     return $statement;
        //     $statement->close();
        // }else{
        //     $statement->close();
        //     return false;
        // }

        $statement = mysqli_query($this->conn,"SELECT * FROM nilaisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    public function storeAbsensi($email,$januari_hadir,$januari_sakit,$januari_izin,
    $februari_hadir,$februari_sakit,$februari_izin,
    $maret_hadir,$maret_sakit,$maret_izin,
    $april_hadir,$april_sakit,$april_izin,
    $mei_hadir,$mei_sakit,$mei_izin){

        $kode_input = uniqid('',true);

        $statement = $this->conn->prepare("INSERT INTO absensisiswa(kode_input,email,
            januari_hadir,januari_sakit,januari_izin,
            februari_hadir,februari_sakit,februari_izin,
            maret_hadir,maret_sakit,maret_izin,
            april_hadir,april_sakit,april_izin,
            mei_hadir,mei_sakit,mei_izin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        $statement->bind_param("ssiiiiiiiiiiiiiii",$kode_input,$email,
            $januari_hadir,$januari_sakit,$januari_izin,
            $februari_hadir,$februari_sakit,$februari_izin,
            $maret_hadir,$maret_sakit,$maret_izin,
            $april_hadir,$april_sakit,$april_izin,
            $mei_hadir,$mei_sakit,$mei_izin);
        $result = $statement->execute();
        $statement->close();
        //cek untuk melihat pengisian data yg sukses
        if($result){
            $statement = $this->conn->prepare("SELECT * FROM absensisiswa WHERE email=?");
            $statement->bind_param("s",$email);
            $statement->execute();
            $absensi = $statement->get_result()->fetch_assoc();
            $statement->close();
            
            return $absensi;
        }else{
            return false;
        }
    }

    function isAbsensiExisted($email){
        $statement = $this->conn->prepare("SELECT ? FROM absensisiswa WHERE email=?");
        $statement->bind_param("s",$email);
        $statement->execute();
        $statement->store_result();

        if($statement->num_rows > 0){
            $statement->close();
            return true;
        }else{
            $statement->close();
            return false;
        }
    }

    function isAbsensiExisted_januari($email){
        $statement = mysqli_query($this->conn,"SELECT januari_hadir,januari_sakit,januari_izin FROM absensisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    function isAbsensiExisted_februari($email){
        $statement = mysqli_query($this->conn,"SELECT februari_hadir,februari_sakit,februari_izin FROM absensisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    function isAbsensiExisted_maret($email){
        $statement = mysqli_query($this->conn,"SELECT maret_hadir,maret_sakit,maret_izin FROM absensisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    function isAbsensiExisted_april($email){
        $statement = mysqli_query($this->conn,"SELECT april_hadir,april_sakit,april_izin FROM absensisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    function isAbsensiExisted_mei($email){
        $statement = mysqli_query($this->conn,"SELECT mei_hadir,mei_sakit,mei_izin FROM absensisiswa WHERE email='$email'");
        
        // $sql->bind_param("s",$email);
        // $response = [];
        while($row = mysqli_fetch_assoc($statement)){
            $response[] = $row;
        }
        return $response;
    }

    // public function storePhone($mobilephone,$fullname){

    //     $statement = $this->conn->prepare("INSERT INTO data_hp(nama_hp,no_hp)VALUES (?,?)");
    //     $statement->bind_param("ss",$no_hp,$nama_hp);
    //     $result = $statement->execute();
    //     $statement->close();

    //     //cek untuk melihat pengisian data yg sukses
    //     if($result){
    //         $statement = $this->conn->prepare("SELECT * FROM data_hp WHERE no_hp=?");
    //         $statement->bind_param("s",$no_hp);
    //         $statement->execute();
    //         $handphone = $statement->get_result()->fetch_assoc();
    //         $statement->close();

    //         return $handphone;
    //     }else{
    //         return false;
    //     }
    // }

    function isPhoneExisted($mobilephone){
        $statement = $this->conn->prepare("SELECT fullname FROM users WHERE mobilephone='$mobilephone'");
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