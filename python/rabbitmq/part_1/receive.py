#Python client
import pika

#Establish a connection with RabbitMQ server
connection = pika.BlockingConnection(
	pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

#Creating the queue hello
channel.queue_declare(queue='gay_fish')

#Infinity loop wating for messages
print ' [*] Waiting for messages. To exit press CTRL+C'

#Declaring a callback to use to receive messages
def callback(ch, method, properties, body):
    print " [x] Received %r" % (body,)
	
channel.basic_consume(callback, queue='gay_fish', 
	no_ack=True)

channel.start_consuming()



