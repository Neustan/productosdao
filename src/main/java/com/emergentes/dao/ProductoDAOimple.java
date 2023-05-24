package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimple extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos (Descripcion,Cantidad,Precio,Categoria) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET Descripcion=?,Cantidad=?,Precio=?,Categoria=? WHERE ?=Id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,producto.getDescripcion());
            ps.setInt(2,producto.getCantidad());
            ps.setFloat(3,producto.getPrecio());
            ps.setString(4,producto.getCategoria());
            ps.setInt(5,producto.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            String sql = "DELETE FROM productos WHERE Id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
         Producto prod = new Producto();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos where Id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
           

            if (rs.next()) {
                prod.setId(rs.getInt("Id"));
                prod.setDescripcion(rs.getString("Descripcion"));
                prod.setCantidad(rs.getInt("Cantidad"));
                prod.setPrecio(rs.getFloat("Precio"));
                prod.setCategoria(rs.getString("Categoria"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prod;

    }

    @Override
    public List<Producto> getAll() throws Exception {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("Id"));
                prod.setDescripcion(rs.getString("Descripcion"));
                prod.setCantidad(rs.getInt("Cantidad"));
                prod.setPrecio(rs.getFloat("Precio"));
                prod.setCategoria(rs.getString("Categoria"));

                lista.add(prod);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;

    }

}
