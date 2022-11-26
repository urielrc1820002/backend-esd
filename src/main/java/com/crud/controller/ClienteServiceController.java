package com.crud.controller;

import com.crud.exception.ClienteNotFoundException;
import com.crud.model.Cliente;
import com.crud.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud.repository.ClienteRepository;
import com.crud.util.ClienteExcelExporter;
import com.crud.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ClienteServiceController {
    @Autowired
    private ClienteService clienteService;
    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public ResponseEntity<Object> createCliente (@RequestBody Cliente cliente)
    {
        cliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>("Cliente is created successfully with id = " + cliente.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCliente (@PathVariable("id") int id,
                                                 @RequestBody Cliente cliente)
    {
        boolean isClienteExist = clienteService.isClienteExist(id);
        if (isClienteExist)
        {
            cliente.setId(id);
            clienteService.updateCliente (cliente);
            return new ResponseEntity<>("Cliente is updated successsfully", HttpStatus.OK);
        }
        else
        {
            throw new ClienteNotFoundException();
        }

    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCliente (@PathVariable("id") int id)
    {
        boolean isClienteExist = clienteService.isClienteExist(id);
        if (isClienteExist)
        {
            Cliente cliente = clienteService.getCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        else
        {
            throw new ClienteNotFoundException();
        }

    }
    @Operation(summary = "Listar clientes")
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<Object> getClientes()
    {
        List<Cliente> ClienteList = clienteService.getClientes();
        return new ResponseEntity<>(ClienteList, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCliente (@PathVariable("id") int id)
    {
        boolean isClienteExist = clienteService.isClienteExist(id);
        if (isClienteExist)
        {
            clienteService.deleteCliente(id);
            return new ResponseEntity<>("Cliente is deleted successsfully", HttpStatus.OK);
        }
        else
        {
            throw new ClienteNotFoundException();
        }

    }
    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_product";
        response.setHeader(headerKey, headerValue);

        List<Cliente> clientes= clienteService.getClientes();

        ClienteExcelExporter excelExporter = new ClienteExcelExporter(clientes);

        excelExporter.export(response);


    }
}
