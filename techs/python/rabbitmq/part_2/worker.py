#Python client
import pika
import time

#Establish a connection with RabbitMQ server
connection = pika.BlockingConnection(
		pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

#Creating the queue task_queue
channel.queue_declare(queue='task_queue', durable=True)

#Infinity loop wating for messages
print ' [*] Waiting for messages. To exit press CTRL+C'

#Declaring a callback to receive messages
def callback(ch, method, properties, body):
    print " [x] Received %r" % (body,)
    time.sleep( body.count('.') )
    print " [x] Done"
    ch.basic_ack(delivery_tag = method.delivery_tag)

channel.basic_qos(prefetch_count=1)
channel.basic_consume(callback,
                      queue='task_queue')

channel.start_consuming()