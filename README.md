<h1>Aplicación Curso AtSistemas</h1>
<p> Aplicación de Gestión realizada con Spring, Hibernate, JPA, Maven y un diseño de estructura en capas:</p>
<b>
  <li>-Controller
  <li>-Service
  <li>-DTOs
  <li>-Model
</b>  
<p> Además el proyecto incluye algunas pruebas unitarias con JUnit y Mocks de pruebas.</p>
<p> Para la ejecución de la aplicación se debe descargar, crear una base de datos local llamada "clinic" y ejecutar.</p>
<p> Tambien se puede ejecutar el archivo clinic.sql como un script para rellenar la base de datos</p>

FUNCIONALIDAD DE LA APLICACIÓN

	-CRUDS de todas las Entidades

	CLÍNICA
	-Listar todas las Clínicas ->	http://localhost:8080/api/clinic
	-Encontrar una Clínica por id ->	http://localhost:8080/api/clinic/{idClinic}
	-Encontrar una Clínica por nombre ->	http://localhost:8080/api/clinic/name={nameClinc}
	-Listar Salas que tiene una Clínica	->	http://localhost:8080/api/clinic/{idClinic}/rooms

	SALA
	-Listar todas las Salas ->	http://localhost:8080/api/room
	-Encontrar una Sala por id ->	http://localhost:8080/api/room/{idRoom}
	-Listar Consultas que tiene una Sala ->	http://localhost:8080/api/room/{idRoom}/consultations

	CONSULTA
	-Listar todas las Consultas ->	http://localhost:8080/api/consultation
	-Encontra una Consulta ->	http://localhost:8080/api/consultation/{idConsultation}
	-Listar Citas que tiene una Consulta ->	http://localhost:8080/api/consultation/{idConsultation}/appointments

	CITA
	-Listar todas las Citas -> http://localhost:8080/api/appointment
	-Encontrar una Cita ->	http://localhost:8080/api/appointment/{idAppointment}

	PACIENTE
	-Listar todas los Pacientes ->	http://localhost:8080/api/patient
	-Encontrar un Paciente ->	http://localhost:8080/api/patient/{idPatient}
	-Listar Citas que tiene un Paciente ->	http://localhost:8080/api/patient/{idPatient}/appointments
	-Numero de Citas de un Paciente ->	http://localhost:8080/api/patient/{idPatient}/num

	MÉDICO
	-Listar todos los Médicos -> http://localhost:8080/api/doctor
	-Encontrar un Médico ->	http://localhost:8080/api/doctor/{idDoctor}
	-Listar Consultas que tiene un Médico ->	http://localhost:8080/api/doctor/{idDoctor}/consultations
	-Listar todos los Médicos de un servicio REST ->	http://localhost:8080/api/doctor/rest
	-Encontrar los N primeros Médicos con mas Pacientes ->		http://localhost:8080/api/doctor/ranking (?size={N})(por defecto muestra los 5 primeros)
	-Encontrar Médicos con Numero de Citas realizadas entre una fecha dada -> http://localhost:8080/api/doctor/stats (?ini=yyyy-mm-dd&end=yyyy-mm-dd)(Por defecto muestra todo el año)
  -Encontrar Médicos con Numero de Citas realizadas entre una fecha dada, numero de citas y benecifios obtenidos -> http://localhost:8080/api/doctor/details


