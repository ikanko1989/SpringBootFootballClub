resource "aws_instance" "springboot_app" {
  ami           = var.ami_id
  instance_type = var.instance_type
  key_name      = var.key_pair_name
  security_groups = [aws_security_group.allow_ssh_ping_8080.name]

  user_data = file("${path.module}/user_data.conf")

  tags = {
    Name = "SpringBootApp"
  }
}
