resource "aws_key_pair" "deployer" {
  public_key = file(var.public_key_path)
  key_name = var.key_pair_name
}
