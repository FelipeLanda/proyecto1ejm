
CREATE DATABASE `proyectogoogle`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

CREATE TABLE `cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `USUARIO_CLIENTE` varchar(15) default NULL,
  `CLAVE_CLIENTE` varchar(15) default NULL,
  `APEPAT_CLIENTE` varchar(20) default NULL,
  `APEMAT_CLIENTE` varchar(20) default NULL,
  `NOMBRES_CLIENTE` varchar(50) default NULL,
  PRIMARY KEY  (`ID_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `cliente` (`ID_CLIENTE`, `USUARIO_CLIENTE`, `CLAVE_CLIENTE`, `APEPAT_CLIENTE`, `APEMAT_CLIENTE`, `NOMBRES_CLIENTE`) VALUES 
  (1,'locoxkiddy','123456','LANDA','ESPINOZA','FELIPE CRISTIAN');

COMMIT;
