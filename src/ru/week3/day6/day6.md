## 🏆 Проектная Задача Недели

### Проект: Система Управления Студентами

**Требования:**
1. **Класс Student:**
    - Свойства: id, name, email, age
    - Приватные поля с getters/setters
    - Валидация в setters
    - Метод displayInfo()

2. **Класс Course:**
    - Свойства: courseName, courseCode, instructor, students (список)
    - Методы:
        - addStudent(student) - добавить студента
        - removeStudent(studentId) - удалить студента
        - getStudentCount() - количество студентов
        - displayAllStudents() - вывести всех студентов в курсе
        - displayCourseInfo() - информация о курсе

3. **Класс University:**
    - Свойства: courses (список курсов)
    - Методы:
        - addCourse(course) - добавить курс
        - findCourse(courseCode) - найти курс
        - displayAllCourses() - вывести все курсы
        - Общее количество студентов во всех курсах

4. **Класс Main (главная программа):**
    - Создайте несколько студентов
    - Создайте несколько курсов
    - Добавьте студентов в курсы
    - Выведите всю информацию