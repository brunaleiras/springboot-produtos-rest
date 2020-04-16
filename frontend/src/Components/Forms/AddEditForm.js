import React from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

class AddEditForm extends React.Component {

    state = { id : 0, nome :'', quantidade:0, valor:0}

    onChange = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitFormAdd = e => {
        e.preventDefault()
        fetch('/produto/gravar', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome: this.state.nome,
                quantidade: this.state.quantidade,
                valor: this.state.valor
            })
        })
            .then(response => response.json())
            .then(item => {
                if(Array.isArray(item)) {
                    this.props.addItemToState(item[0])
                    this.props.toggle()
                } else {
                    console.log('failure')
                }
            })
            .catch(err => console.log(err))
    }

    submitFormEdit = e => {
        e.preventDefault()
        fetch('/produto/atualizar', {
            method: 'put',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                nome: this.state.nome,
                quantidade: this.state.quantidade,
                valor: this.state.valor
            })
        })
            .then(response => response.json())
            .then(item => {
                if(Array.isArray(item)) {
                    // console.log(item[0])
                    this.props.updateState(item[0])
                    this.props.toggle()
                } else {
                    console.log('failure')
                }
            })
            .catch(err => console.log(err))
    }

    componentDidMount(){
        // if item exists, populate the state with proper data
        if(this.props.item){
            const { nome, quantidade, valor } = this.props.item
            this.setState({ nome, quantidade, valor })
        }
    }

    render() {
        return (
            <Form onSubmit={this.props.item ? this.submitFormEdit : this.submitFormAdd}>
            <FormGroup>
            <Label for="first">Nome</Label>
        <Input type="text" name="nome" id="nome" onChange={this.onChange} value={this.state.nome === null ? '' : this.state.nome} />
        </FormGroup>
        <FormGroup>
        <Label for="last">Quantidade</Label>
        <Input type="text" name="quantidade" id="quantidade" onChange={this.onChange} value={this.state.quantidade === null ? '' : this.state.quantidade}  />
        </FormGroup>
        <FormGroup>
        <Label for="email">Valor</Label>
            <Input type="text" name="valor" id="valor" onChange={this.onChange} value={this.state.valor === null ? '' : this.state.valor}  />
        </FormGroup>

        <Button>Submit</Button>
        </Form>
    );
    }
}

export default AddEditForm
