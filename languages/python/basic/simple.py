class Car():
    
    val = 0
    name = "Mercedes"

    def __init__(self, val, name):
        self.val = val
        self.name = name
        self

class People():
    
    car = Car(0, "")
    name = "Jeff" 
    
    def __init__(self, car = Car(100, "Chevetao")):
        self.car = car
        self

    def setName(self, name):
        self.name = name

    def __str__(self):
        print "This " + name + " takes a lot of people"

class Employee():
    
    def salary(self):
        return 100    

class Test():

    def test(self, emp):
        print emp.salary()


def main():

    # single line comment

    """ this is a multiline comment
        which spawns many lines
    """
    
    people = People("Cheveteti")
    people.setName("Cuervo")
    #print "Esse " + people.name + " cozinha as pessoas e tem um " + people.car.name
    
    test = Test()
    test.test(Employee())
    

if  __name__ == '__main__':
    main()


