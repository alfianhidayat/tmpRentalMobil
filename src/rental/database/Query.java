/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.database;

/**
 *
 * @author Alfian Hidayat
 */
public class Query {

    public final String SELECT_USER_QUERY = "SELECT * FROM tb_user;";
    public final String SELECT_USER_LOGIN_QUERY = "SELECT * FROM tb_user WHERE username = ? AND password  = ?";
    public final String SELECT_USER_ISADMIN_QUERY = "SELECT username FROM tb_user WHERE status = 1;";
    public final String SELECT_USER_SELECTED_QUERY = "SELECT password FROM tb_user WHERE username = ?;";
    public final String INSERT_USER_QUERY = "INSERT INTO tb_user VALUES (?,?,0);";
    public final String DELETE_USER_QUERY = "DELETE FROM tb_user WHERE username=? and password=?;";
    public final String UPDATE_USER_QUERY = "UPDATE tb_user SET password = ? WHERE username = ?;";
    
    public final String SELECT_MEMBER_QUERY = "SELECT * FROM tb_member WHERE status = 1 ORDER BY id_member ASC;";
    public final String SELECT_COUNT_MEMBER_QUERY = "SELECT COUNT(id_member) AS no FROM tb_member;";
    public final String SELECT_LIKE_MEMBER_QUERY = "SELECT * FROM tb_member WHERE status = 1 AND (id_member LIKE ? OR nama LIKE ?)  ORDER BY id_member ASC;";
    public final String SELECT_MEMBER_SELECTED_QUERY = "SELECT * FROM tb_member WHERE id_member = ?;";
    public final String UPDATE_MEMBER_QUERY = "UPDATE tb_member SET nama = ?, noktp = ?, alamat=?, nohp=?, jeniskelamin=? WHERE id_member = ?;";
    public final String DELETE_MEMBER_QUERY = "UPDATE tb_member SET status = 0 WHERE id_member=?;";
    public final String INSERT_MEMBER_QUERY = "INSERT INTO tb_member VALUES (?,?,?,?,?,?,1);";

    public final String SELECT_KENDARAAN_QUERY = "SELECT * FROM tb_kendaraan WHERE ket = 1 ORDER BY id_kendaraan ASC;";
    public final String SELECT_COUNT_KENDARAAN_QUERY = "SELECT COUNT(id_kendaraan) AS no FROM tb_kendaraan;";
    public final String SELECT_LIKE_KENDARAAN_QUERY = "SELECT * FROM tb_kendaraan WHERE ket = 1 AND (id_kendaraan LIKE ? OR no_plat LIKE ? OR merek LIKE ? OR warna LIKE ? OR tahun LIKE ? OR jenis LIKE ? OR kondisi LIKE ? OR status LIKE ?) ORDER BY id_kendaraan ASC;";
    public final String SELECT_KENDARAAN_AVAILABLE_QUERY = "SELECT id_kendaraan FROM tb_kendaraan WHERE status = 'Tersedia' AND kondisi = 'Baik' AND jenis = ? AND ket = 1;";
    public final String SELECT_KENDARAAN_SELECTED_QUERY = "SELECT * FROM tb_kendaraan WHERE id_kendaraan = ?;";
    public final String INSERT_KENDARAAN_QUERY = "INSERT INTO tb_kendaraan VALUES (?,?,?,?,?,?,?,?,?,1);";
    public final String UPDATE_KENDARAAN_QUERY = "UPDATE tb_kendaraan SET no_plat = ?,merek = ?, warna = ?, harga = ?, tahun = ?, jenis = ?, kondisi = ?, status = ? WHERE  id_kendaraan = ?; ";
    public final String UPDATE_STATUS_KENDARAAN_QUERY = "UPDATE tb_kendaraan SET status = ? WHERE id_kendaraan = ?;";
    public final String DELETE_KENDARAAN_QUERY = "UPDATE tb_kendaraan SET ket = 0 WHERE id_kendaraan=?;";
    
    public final String SELECT_PENYEWAAN_JOIN_QUERY = "SELECT p.no_faktur, m.nama, k.merek, p.tgl_sewa, p.tgl_kembali, p.total_bayar FROM tb_penyewaan AS p, tb_member AS m, tb_kendaraan AS k WHERE k.id_kendaraan = p.id_kendaraan AND m.id_member = p.id_member ORDER BY no_faktur ASC";
    public final String SELECT_LIKE_PENYEWAAN_JOIN_QUERY = "SELECT p.no_faktur, m.nama, k.merek, p.tgl_sewa, p.tgl_kembali, p.total_bayar FROM tb_penyewaan AS p, tb_member AS m, tb_kendaraan AS k WHERE (k.id_kendaraan = p.id_kendaraan AND m.id_member = p.id_member)"
            + " AND (p.no_faktur LIKE ? OR m.nama LIKE ? OR k.merek LIKE ? OR p.tgl_sewa LIKE ? OR p.tgl_kembali LIKE ? OR p.total_bayar LIKE ?) ORDER BY no_faktur ASC";
    public final String SELECT_COUNT_PENYEWAAN_QUERY = "SELECT COUNT(no_faktur)as no FROM tb_penyewaan;";
    public final String INSERT_PENYEWAAN_QUERY = "INSERT INTO tb_penyewaan VALUES (?,?,?,?,?,?,?);";

    public final String SELECT_COUNT_KEMBALI_QUERY = "SELECT COUNT(id_kembali) AS no FROM tb_kembali;";
    public final String INSERT_KEMBALI_QUERY = "INSERT INTO tb_kembali VALUES (?,?,?,?,?);";
    
    public final String SELECT_VIEW_DATAKEMABLI_QUERY = "SELECT * FROM dataKembali WHERE no_faktur = ?;";
    
}
