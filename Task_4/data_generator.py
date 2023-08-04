from mimesis import Generic
from mimesis.builtins import RussiaSpecProvider
from mimesis.shortcuts import romanize
from random import randint
from random import random

generic = Generic('ru')
rus_generic = RussiaSpecProvider()

count_rows = 1000

car_manufacturers = ['Skoda', 'Mercedes-Benz', 'Volkswagen', 'Mini', 'Porsche', 'Aston Martin', 'Dodge',
                     'Lotus', 'Hyundai', 'Saab', 'Mitsubishi', 'Chevrolet', 'Toyota', 'Suzuki']

def generate_clients():
    f = open('C:\JavaCourse\JavaCourse\Task_4\clients.csv', 'w')
    
    for i in range(count_rows):
        line = "{0}:{1}:{2}:{3}\n".format(i, 
                    romanize(generic.person.full_name(), 'ru'), 
                    generic.datetime.date(start=1950, end=2000),
                    randint(1, 2) == 1)
        f.write(line)
    
    f.close()

def generate_cars():
    f = open('C:\JavaCourse\JavaCourse\Task_4\cars.csv', 'w')

    for i in range(count_rows):
        line = "{0}:{1}:{2}:{3}:{4}:{5}\n".format(i, car_manufacturers[i % len(car_manufacturers)],
                romanize(generic.text.color(), 'ru'), random() * 2000.0 + 1600.0, 
                generic.datetime.date(start=2000, end=2022), randint(1000000, 5000000)) 
        f.write(line)
    
    f.close()

def generate_customer_orders():
    f = open('C:\JavaCourse\JavaCourse\Task_4\customer_orders.csv', 'w')

    for i in range(count_rows):
        line = "{0}:{1}:{2}\n".format(randint(0, 999), randint(0, 999),
                                generic.datetime.date(start=2020, end=2022))
        f.write(line)
    
    f.close()

#generate_clients()
#generate_cars()
#generate_customer_orders()