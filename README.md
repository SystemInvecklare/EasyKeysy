# EasyKeysy

Java library for simple encryption without the all the hassle.

## Public-private key pair

First we need to generate a key pair. These are two strings. The public key is used for encrypting/creating a secret message, and the private key is used to decrypt/read a secret message.

```java
Base64KeyPair keyPair = KeyPairGenerationUtil.createKeyPair();
System.out.println("Public key: "+keyPair.publicKey);
System.out.println();
System.out.println("Private key: "+keyPair.privateKey);
```

For example, might print:

```
Public key: MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyNHqTqUx8Q8pavMo0H5RSbQiwAaT7WAscPlTeGkxmQHoauL4qxQ8TwuBtm+5zUD0WUfmmOD5mO2qL2gNLKx/CFlBXBa6KM7Va+y4md4iQVSvuKmAJM2e3hmcdB5ou6u+anMo9q2O9OWxEnXuPhxOjenAUzQORXm0ZK0uSn0PGWPe3KswJsWBBfE3gZvAiMs2r6eO6mHviViG0BkrsolCkCJP5cat66dBA4aF0Gu/oD8+QKYUtNVjr1rbxWDQ6NvwiNATQaH2tBUBpe6EobzM/yVHmUEEpZ4C/JYPzTKxrAIGH25b2iFuJGrEcE66SWI02VNTvgw7D1kAgUd16gEG6wIDAQAB

Private key: MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDI0epOpTHxDylq8yjQflFJtCLABpPtYCxw+VN4aTGZAehq4virFDxPC4G2b7nNQPRZR+aY4PmY7aovaA0srH8IWUFcFrooztVr7LiZ3iJBVK+4qYAkzZ7eGZx0Hmi7q75qcyj2rY705bESde4+HE6N6cBTNA5FebRkrS5KfQ8ZY97cqzAmxYEF8TeBm8CIyzavp47qYe+JWIbQGSuyiUKQIk/lxq3rp0EDhoXQa7+gPz5AphS01WOvWtvFYNDo2/CI0BNBofa0FQGl7oShvMz/JUeZQQSlngL8lg/NMrGsAgYfblvaIW4kasRwTrpJYjTZU1O+DDsPWQCBR3XqAQbrAgMBAAECggEALJTVVFI+DQrVogWLOQXh29/emwyayGbCVu4yxpdryFDxHNF4bNpYLSAb0rlo4RUbabqZibTgFEAmuNF7o0BED0FpTh1JhIeuP4BU1uvGZQR84hzW8tSnAR1kay7ZB1iwNAeOv3x2MQ3Qyo1dr3IvSjfrV01GIcxL7NG5ZhXvRS5OpgQRVMz94C+nohiTrKU/xZehQbQk7qsV3+55gYiHA/l1zYuiqC7GEC+/BrU19xOP42Otsg9ixSJ+NQMnFk+VsrZZQ00j/TRt40OtzN8H62cQ7TBu7HTNeJfS68XR8dwQhW6aOHcTqE1bAc/2NHfjJXBzHlOyBLJM8X3D/EVjeQKBgQD2UZlxxfn82/blkFE+Gc6t7HJFBmUuYQNbHaY4V+aVfjJKZ1AgEBfHZe93xx6vjAXx4jE/iw0o2SZ1K5PZ5m6X7xR4HoRA17RKOAKf/RvFoCWWumczfRH9mkoaQPM6Gj0YUAt8HW5wz1R4sL4BBylaNR5Od9qE7V5GM83MgOAE9QKBgQDQtoSjNm+5olu7rfdWr8r1s0touuBujIo61D6GeL26hZ76wrEJ6R6BmtAzs2UELeL98hwPkWbgMSt9yHVIoLlS//aNVKiSFStdXMFzfjP059LDZPEBlW8c0ILUxi10O1tHEHz5ens1gkFLW7XQq8byO0X9mzzO6w69iz3GcWRwXwKBgQCWYU0H+/FaYcSDdK9U9ZaL8n31DCl7vji5SQmw/mFFRW1YpWhymsCZuO8RNlzSme8LNKgSfkdDeAeVo0w5zQgZ9BmQGDlwCQEGCtn3aSSqa9JnClh1Q9dW9/pjuuGDyH8iN8Q7OxCxCLMul+D4abHiY+mjyGJ9oxlaTMhJISkjfQKBgQCOxXwAJfnRc6XqwbtjekeNQcQA9W0XUl4wlgXbePbYhBVXlh0DGYv7vopUA5DDhhwz+Q2G/MDx9dC5b4oDT6bWhzACR/o0S/TpHc1bkuY5zudXMFLI8Y8bl+sXYCWxz/TFrRrAki98UAkYYrkB8K/b/f4H2MyFAziHIpv0hpbdYwKBgEInPxu3iuZSYSldEOAcTnUaoazEysRYKYOhTlSER0gR39AmQfrphgiUtgPQDVHH+HxrhPfFZtCxGLdPGln8xYzTNmwbrgNM9yo2qeKlxRgKcjpYtj6ZeBCsE+F95aESpIVg0G/24x8oKAVzcl+jt5LX21miB5JOMODmXIS7PhHa
```


##  Encrypting/creating a secret message

To encrypt a byte-array, use `SecretMessage.makeSecret(String publicKey, byte[] data)`.

##### Example
```java
String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyNHqTqUx8Q8pavMo0H5RSbQiwAaT7WAscPlTeGkxmQHoauL4qxQ8TwuBtm+5zUD0WUfmmOD5mO2qL2gNLKx/CFlBXBa6KM7Va+y4md4iQVSvuKmAJM2e3hmcdB5ou6u+anMo9q2O9OWxEnXuPhxOjenAUzQORXm0ZK0uSn0PGWPe3KswJsWBBfE3gZvAiMs2r6eO6mHviViG0BkrsolCkCJP5cat66dBA4aF0Gu/oD8+QKYUtNVjr1rbxWDQ6NvwiNATQaH2tBUBpe6EobzM/yVHmUEEpZ4C/JYPzTKxrAIGH25b2iFuJGrEcE66SWI02VNTvgw7D1kAgUd16gEG6wIDAQAB";

SecretMessage secret = SecretMessage.makeSecret(publicKey, "Hey ho! This is a secret message!".getBytes(StandardCharsets.UTF_8));

System.out.println(secret); //Same as System.out.println(secret.toString());
```

Might print:

```
344;oqRH48aNNU46Y9s4Hl4ixte+xWis3sDu/VGmvomQJzAvBQOzzsKFA4qPDMzDMbg7675xVr020lIZuY1VnLQ/tORKyePUSvTMUFcQwoSbUuMWs8RCQibGe+N7GQJwlYJx8qV3MzoQLlEX8k7Lx/fY6LDTZlKZFs2CRAbkrtvuouewiAWU7ArPEhdcYZBstu8n7Et32t1LuCbUFhEkbY+vjTNr45yJCIVDV3bJFqvqr7Q5NLOJz8WmdmK12fZv+zCad3SQuiLcD5jFF571jcKsmzWCCAuasItccJkq5EQrZgg/+kazVJwirPUq0j4KsJN9Y5ZGNzC7HHoHAnPxzecehg==MYwbiS3LuK6DaizBJKJh+EJnwV9EUbdxEsyg/6sN2J0OkEItjGeRkIHifOBSC3vh
```

This is the message we can send to our recipient who has the corresponding private key.

## Decrypting/reading a secret message

To read a secret message given to us a String, we first convert it to a `SecretMessage` using `SecretMessage.fromString(String string)`.

Then we use `byte[] decode(String privateKey)`  on the `SecretMessage` object to recover the original message.

```java
SecretMessage secret = SecretMessage.fromString("344;oqRH48aNNU46Y9s4Hl4ixte+xWis3sDu/VGmvomQJzAvBQOzzsKFA4qPDMzDMbg7675xVr020lIZuY1VnLQ/tORKyePUSvTMUFcQwoSbUuMWs8RCQibGe+N7GQJwlYJx8qV3MzoQLlEX8k7Lx/fY6LDTZlKZFs2CRAbkrtvuouewiAWU7ArPEhdcYZBstu8n7Et32t1LuCbUFhEkbY+vjTNr45yJCIVDV3bJFqvqr7Q5NLOJz8WmdmK12fZv+zCad3SQuiLcD5jFF571jcKsmzWCCAuasItccJkq5EQrZgg/+kazVJwirPUq0j4KsJN9Y5ZGNzC7HHoHAnPxzecehg==MYwbiS3LuK6DaizBJKJh+EJnwV9EUbdxEsyg/6sN2J0OkEItjGeRkIHifOBSC3vh");

String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDI0epOpTHxDylq8yjQflFJtCLABpPtYCxw+VN4aTGZAehq4virFDxPC4G2b7nNQPRZR+aY4PmY7aovaA0srH8IWUFcFrooztVr7LiZ3iJBVK+4qYAkzZ7eGZx0Hmi7q75qcyj2rY705bESde4+HE6N6cBTNA5FebRkrS5KfQ8ZY97cqzAmxYEF8TeBm8CIyzavp47qYe+JWIbQGSuyiUKQIk/lxq3rp0EDhoXQa7+gPz5AphS01WOvWtvFYNDo2/CI0BNBofa0FQGl7oShvMz/JUeZQQSlngL8lg/NMrGsAgYfblvaIW4kasRwTrpJYjTZU1O+DDsPWQCBR3XqAQbrAgMBAAECggEALJTVVFI+DQrVogWLOQXh29/emwyayGbCVu4yxpdryFDxHNF4bNpYLSAb0rlo4RUbabqZibTgFEAmuNF7o0BED0FpTh1JhIeuP4BU1uvGZQR84hzW8tSnAR1kay7ZB1iwNAeOv3x2MQ3Qyo1dr3IvSjfrV01GIcxL7NG5ZhXvRS5OpgQRVMz94C+nohiTrKU/xZehQbQk7qsV3+55gYiHA/l1zYuiqC7GEC+/BrU19xOP42Otsg9ixSJ+NQMnFk+VsrZZQ00j/TRt40OtzN8H62cQ7TBu7HTNeJfS68XR8dwQhW6aOHcTqE1bAc/2NHfjJXBzHlOyBLJM8X3D/EVjeQKBgQD2UZlxxfn82/blkFE+Gc6t7HJFBmUuYQNbHaY4V+aVfjJKZ1AgEBfHZe93xx6vjAXx4jE/iw0o2SZ1K5PZ5m6X7xR4HoRA17RKOAKf/RvFoCWWumczfRH9mkoaQPM6Gj0YUAt8HW5wz1R4sL4BBylaNR5Od9qE7V5GM83MgOAE9QKBgQDQtoSjNm+5olu7rfdWr8r1s0touuBujIo61D6GeL26hZ76wrEJ6R6BmtAzs2UELeL98hwPkWbgMSt9yHVIoLlS//aNVKiSFStdXMFzfjP059LDZPEBlW8c0ILUxi10O1tHEHz5ens1gkFLW7XQq8byO0X9mzzO6w69iz3GcWRwXwKBgQCWYU0H+/FaYcSDdK9U9ZaL8n31DCl7vji5SQmw/mFFRW1YpWhymsCZuO8RNlzSme8LNKgSfkdDeAeVo0w5zQgZ9BmQGDlwCQEGCtn3aSSqa9JnClh1Q9dW9/pjuuGDyH8iN8Q7OxCxCLMul+D4abHiY+mjyGJ9oxlaTMhJISkjfQKBgQCOxXwAJfnRc6XqwbtjekeNQcQA9W0XUl4wlgXbePbYhBVXlh0DGYv7vopUA5DDhhwz+Q2G/MDx9dC5b4oDT6bWhzACR/o0S/TpHc1bkuY5zudXMFLI8Y8bl+sXYCWxz/TFrRrAki98UAkYYrkB8K/b/f4H2MyFAziHIpv0hpbdYwKBgEInPxu3iuZSYSldEOAcTnUaoazEysRYKYOhTlSER0gR39AmQfrphgiUtgPQDVHH+HxrhPfFZtCxGLdPGln8xYzTNmwbrgNM9yo2qeKlxRgKcjpYtj6ZeBCsE+F95aESpIVg0G/24x8oKAVzcl+jt5LX21miB5JOMODmXIS7PhHa";

byte[] recoveredData = secret.decode(privateKey);
String recoveredMessage = new String(recoveredData, StandardCharsets.UTF_8);
System.out.println(recoveredMessage);
```

will print

```
Hey ho! This is a secret message!
```

## Encryptor and Decryptor

For easily encrypting and decrypting Strings we store `Encryptor`s and `Decryptors`:

```
Encryptor encryptor = ...;
Decryptor decryptor = ...;
Charset stringEncoding = StandardCharsets.UTF_8;

String secretMessage = encryptor.encrypt("This is very secret", stringEncoding).toString();
...
System.out.println(decryptor.decrypt(SecretMessage.fromString(secretMessage), stringEncoding)); //Prints 'This is very secret'

```