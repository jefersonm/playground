#Python client
import pika

#Establish a connection with RabbitMQ server
connection = pika.BlockingConnection(
	pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

#Creating the queue hello
channel.queue_declare(queue='gay_fish')

channel.basic_publish(exchange='', routing_key='gay_fish', 
	body='Poletto is a gay fish!!!')
print "[x] Sent 'Gay fish message!'"

connection.close()


