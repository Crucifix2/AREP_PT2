# PASOS

pasos

### COMANDOS NECESARIOS PARA LA INSTANCIA EC2:

**ACTUALIZAR SOFTWARE INSTANCIA EC2**: `sudo yum update -y` 
**INSTALAR GITHUB INSTANCIA EC2**: 
```
sudo yum install git -y
git — version
git config — global user.name “Your Name”
git config — global user.email “your_email@example.com”
```
**INSTALAR JAVA  Y MAVEN INSTANCIA EC2**:
```
sudo wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
``` 

```
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
```

```
sudo yum install -y apache-maven
```

```
sudo yum install java-1.8.0-devel
```

```
sudo yum install java-1.8.0-devel
```

```
sudo /usr/sbin/alternatives --config java
```

```
sudo /usr/sbin/alternatives --config javac
```

**INSTALAR DOCKER**: 

```
sudo amazon-linux-extras install docker
```

```
sudo yum install -y docker
```

```
sudo service docker start
```

**INSTALAR DOCKER COMPOSE**:

**ELIMINAR TODAS LAS IMÁGENES DE DOCKER**: `docker rmi $(docker images -a -q)`
**ELIMINAR TODOS LOS CONTENEDORES DE DOCKER**: 

```
sudo docker stop $(docker ps -a -q)
```

```
sudo docker rm $(docker ps -a -q)
```


### PREREQUISITOS

* [Java (desde la 15 para delante)](https://www.oracle.com/co/java/technologies/downloads/) 
* [Maven](https://maven.apache.org/download.cgi) 
* [Git](https://git-scm.com/downloads)
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)

### REQUISITOS

1. Contar con IDE para la ejecución del proyecto o línea de comandos.
2. Contar con los prerequisitos.
3. Tener Docker Desktop
4. Al tenerlos, ejecutar el siguiente comando en la maquina

```bash
git clone ...
```

## Ejecución localmente

1. Clona el repositorio:

```
git clone ...
```

2. Ve a la carpeta raíz del repositorio clonado: 

```
cd (nombre)
```

3. Usa el siguiente comando para construir el proyecto:

```
mvn clean install
```

4. Para ejecutar la aplicación ejecuta el siguiente comando:

```
java -cp target/AREPPT2-1.0-SNAPSHOT.jar co.edu.escuelaing.AREPPT2.ParcialT2  
```

5. Ingresa a http://localhost:4500

## Crear la Imágen del Aplicativo

1. Asegúrate de tener Docker Desktop.
2. Clone el repositorio:
   
```
git clone ...
```
    
3. Navega a la carpeta del proyecto:
   
```
cd ...
```
    
6. Construye el proyecto usando Maven:
   
```
mvn clean install 
```
    
8. Usando la herramienta de línea de comandos de Docker construye la imagen (Reemplace <nombre-imagen> con el nombre que desea darle a la imagen):
   
```
docker build --tag <nombre-imagen> .
```

10. Verifica que la imagen se haya creado correctamente ejecutando el siguiente comando:
    
```
docker images
```

12. Ya si se desea crear un contenedor con la imágen reemplace <nombre-contenedor> y <nombre-imagen> con el nombre que desea darle al contenedor y el nombre de la imágen que  dió anteriormente:
    
```
docker run -d -p 35001:46000 --name <nombre-contenedor> <nombre-imagen>
```

14. Asegúrese que el contenedor está corriendo:
    
```
docker ps
```

11. Abre un navegador web y accede a la aplicación en http://localhost:35001.

## Generar el Repositorio con la imágen creada

1. Registre las credenciales de su cuenta de dockerhub:

```
docker login
```
2. Vea la imágen a la que pondrá en el repositorio:

```
docker images
```

3. Cree una referencia a su imagen con el nombre del repositorio a donde desea subirla:

```
docker tag <nombre-imagen> fdanielmc/<nombre-repositorio-a-crear>
```

## Ejecución desde la imágen del Repositorio

1. Instale Docker Desktop.
2. Revise que no tenga imágenes docker.
   
```
docker images
```

3. Descargar la imágen desde el repositorio.

```
docker pull fdanielmc/<nombre-repositorio>:latest
```

5. Verifica que la imagen se haya creado correctamente ejecutando el siguiente comando:
```
docker images
```

6. Cree un nuevo contenedor a partir de la imagen que está en Docker Hub:
   
```
docker run -d -p 35000:46000 --name <nombre-contenedor> fdanielmc/<repositorio>
```

7. Asegúrese que el contenedor está corriendo:
   
```
docker ps
```

8. Abre un navegador web y accede a la aplicación en http://localhost:35000.


## Casos de Prueba


## DESARROLLADO CON

* [Java version 15 (Netbeans JDK 15)](https://www.oracle.com/co/java/technologies/downloads/)
* [Maven](https://maven.apache.org/download.cgi)
* [Git](https://git-scm.com/downloads)
* [Docker](https://www.docker.com/products/docker-desktop/)

## Autor

* **Daniel Fernando Moreno Cerón** - [FDanielMC](https://github.com/FDanielMC)

### Licencia

This project is licensed under the MIT License - see the LICENSE.md file for details

### Agradecimientos

Escuela Colombiana de Ingeniería
