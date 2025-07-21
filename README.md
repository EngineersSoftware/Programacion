# Sistema de Gestión de Empleados

## Descripción
Este proyecto es un sistema de gestión de empleados que permite manejar diferentes tipos de trabajadores en una organización. Implementa el patrón de diseño MVC (Modelo-Vista-Controlador) y utiliza herencia y polimorfismo para manejar diferentes tipos de empleados.

## Estructura del Proyecto

```
├── Model/                 # Clases de dominio
│   ├── Employee.java     # Clase abstracta base
│   ├── Administrator.java # Empleado administrativo
│   ├── Electrician.java  # Empleado electricista
│   └── Technical.java    # Empleado técnico
│
├── View/                 # Interfaz de usuario
│   └── Main.java        # Clase principal con CLI
│
├── Controllers/         # Lógica de negocio
│   ├── EmployeController.java # Controlador principal
│   └── Exceptions/     # Manejo de errores
│
└── Service/            # Interfaces y servicios
    └── interfaces/    # Interfaces para servicios
```

### Clase Abstracta Employee
```java
public abstract class Employee {
    // Atributos
    private Integer workerId;     // Identificador único del empleado
    private String name;          // Nombre del empleado
    private Double salary;        // Salario del empleado
    private Date schedule;        // Horario de trabajo

    // Métodos abstractos
    abstract void work();         // Método que define el trabajo específico del empleado
}
```

## Características
- Gestión de diferentes tipos de empleados (Administradores, Electricistas, Técnicos)
- CRUD completo (Crear, Leer, Actualizar, Eliminar)
- Validación de datos y manejo de excepciones
- Interfaz de línea de comandos intuitiva
- Mantenimiento del tipo específico al actualizar empleados

## Requisitos
- Java JDK 8 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, NetBeans)

## Instalación
1. Clonar el repositorio
2. Abrir el proyecto en un IDE Java
3. Compilar y ejecutar la clase `Main`

## Uso
El programa se ejecuta desde la línea de comandos y ofrece las siguientes opciones:
1. Agregar Empleado
2. Listar Empleados
3. Actualizar Empleado
4. Eliminar Empleado
5. Salir

## Ejemplo de Uso
```java
// Agregar un nuevo empleado
ID del empleado: 1
Nombre: Juan Pérez
Salario: 5000.0
Tipo de empleado:
1. Administrador
2. Electricista
3. Técnico
Seleccione tipo: 1
Nivel de acceso: Administrador Principal

// Listar empleados
=== Lista de Empleados ===
ID: 1 | Nombre: Juan Pérez | Salario: 5000.0 | Horario: Sun Jul 21 03:25:45 COT 2024
```

## Contribución
1. Clonar el repositorio
2. Crear una rama para tu funcionalidad (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia
Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE para más detalles